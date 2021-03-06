(require '[clojure.zip :as zip])

;;; Exercise 1

(def all-vectors
     (fn [tree]
       (letfn [(all-from-zipper [so-far zipper]
                 (cond (zip/end? zipper)
                       so-far
                       
                       (zip/branch? zipper)
                       (all-from-zipper so-far (zip/next zipper))

                       (vector? (zip/node zipper))
                       (all-from-zipper (cons (zip/node zipper) so-far)
                               (zip/next zipper))

                       :else
                       (all-from-zipper so-far (zip/next zipper))))]
         (reverse (all-from-zipper '() (zip/seq-zip tree))))))


(prn (all-vectors '(fn [a b] (concat [a] [b]))))

;; This collapses two branches to make it a little terser:

(def all-vectors-2
     (fn [tree]
       (letfn [(all-from-zipper [so-far zipper]
                 (cond (zip/end? zipper)
                       so-far
                       
                       (vector? (zip/node zipper))
                       (all-from-zipper (cons (zip/node zipper) so-far)
                               (zip/next zipper))

                       :else
                       (all-from-zipper so-far (zip/next zipper))))]
         (reverse (all-from-zipper '() (zip/seq-zip tree))))))




;;; Exercise 2

(def first-vector
     (fn [tree]
       (letfn [(all-from-zipper [zipper]
                  (cond (zip/end? zipper)
                        nil
                       
                       (vector? (zip/node zipper))
                       (zip/node zipper)
                       
                       :else
                       (all-from-zipper (zip/next zipper))))]
         (all-from-zipper (zip/seq-zip tree)))))

(prn (first-vector '(fn [a b] (concat [a] [b]))))
(prn (first-vector '(+ 1 (* 3 4))))



;;; Solutions to the second set of zipper exercises follow.

;;; Exercise 3

;; This is a handy function for inserting into a flow:
;; (-> zipper zlog zip/right zlog...)
(def zlog
     (fn [z] (println "LOG:" (pr-str (zip/node z))) z))

;; This prints the tree above the current node.
(def zuplog
     (fn [z] (zlog (zip/up z)) z))

;;; I'm breaking out some predicates because they seem generally useful

(def at?
     (fn [zipper subtree] (= (zip/node zipper) subtree)))

(def above?
     (fn [zipper subtree]
       (and (zip/branch? zipper)
            (at? (zip/down zipper) subtree))))

;;; The clever thing I'm doing is to want to extract out the part that
;;; happens in every case: using `zip/next` and making the recursive
;;; call.  That is done by creating a function `advancing`. The
;;; interesting thing is that `advancing` doesn't need to be given the
;;; zipper.  It can instead be given a function (`flow`) that does
;;; whatever work is required before `zip/next` is called.
;;;
;;; Why doesn't `advancing` need to be given a zipper? Because *each*
;;; call to `do-node` provides a new zipper, and any of the functions
;;; given to `advancing` can close over it. Therfore, they can
;;; present to `advancing` an argument-free function that it should call,
;;; knowing that function encapsulates the current value of the
;;; zipper.

;;; Note: I'd normally factor out helper functions that combine zipper
;;; functions. I thought these examples would be clearer if I left them with
;;; long strings of zip/this, zip/that, zip/the-other.

(def tumult
     (fn [form]
       (letfn [(advancing [flow]
                          (-> (flow) zip/next do-node))
               (do-node [zipper]
                        (cond (zip/end? zipper)
                              zipper
                              
                              (at? zipper '+)
                              (advancing (fn [] (zip/replace zipper 'PLUS)))

                              (above? zipper '-)
                              (advancing (fn [] (zip/append-child zipper 55555)))
                              
                              (above? zipper '*)
                              (advancing (fn [] (zip/replace zipper
                                                             '(/ 1 (+ 3 (- 0 9999))))))
                              
                              (at? zipper '/)
                              (advancing (fn []
                                           (-> zipper
                                               zip/right
                                               zip/remove
                                               zip/right
                                               zip/remove
                                               (zip/insert-right (-> zipper zip/right zip/node))
                                               (zip/insert-right (-> zipper zip/right zip/right zip/node))
                                               zip/next
                                               do-node)))
                              
                              :else
                              (advancing (constantly zipper))))]
         (-> form zip/seq-zip do-node zip/root))))



