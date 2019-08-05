;; Exercise 1

;; Partial way
(map (partial + 2) [1 2 3])

;; Comp way
(map (comp inc inc) [1 2 3])

;; Exercise 2
(def separate
  (fn [pred sequence]
    ((juxt filter remove ) pred sequence)))

;; Exercise 4

(def myfun
  ((fn [x]
     (fn [] x)) 3))

;; Exercise 5

(def my-atom (atom 0))
(swap! my-atom (fn [__] 33))

;; Exercise 6
(def always
  (fn [v]
    (fn [& args] v)))

;; Exercise 7
(def check-sum
  (fn [sequence]
      (reduce +
              (map * sequence (range 1 (inc (count sequence)))))))

;; Exercise 8

;;; `reversed-digits` takes advantage of two new facts (that aren't
;;; used in the rest of the book):
;;;
;;; 1. Java interoperability allows you to call Java methods--both
;;;    instance methods and class methods. So you can call one of
;;;    Java's Integer constructors like this:
;;;
;;;       user=> (Integer. "321")
;;;       321
;;;
;;; 2. Strings are sequences, so you can apply sequence functions
;;;    to them. The result isn't a string, though, but rather a
;;;    sequence of Java Characters:
;;;    
;;;       user=> (reverse "foo")
;;;       (\o \o \f)
;;;
;;;    You can convert a character into a string with `str`:
;;;       user=> (str \o)
;;;       "o"
;;;
;;; Thanks to Jeremy W. Sherman for a version that improved on my
;;; original.

(def reversed-digits
     (fn [string]
       (map (fn [digit-char]
              (-> digit-char str Integer.))
            (reverse string))))

;; (isbn? "0131774115")
;; (isbn? "0977716614")
;; (isbn? "1934356190")


;; (upc? "074182265830")
;; (upc? "731124100023")
;; (upc? "722252601404") ;; This one is incorrect.

(def isbn?
  (fn [string]
    (= 0 (rem (check-sum (reversed-digits string)) 11))))

;; Exercise 9
(def multiply-if-even-position
  (fn [position e]
    (if (odd? position)
      e
      (* e 3))))

(def check-sum-upc
  (fn [sequence]
    (reduce + (map multiply-if-even-position
                   (range 1 (inc (count sequence)) )
                   sequence))))

(def upc?
  (fn [candidate]
    (= 0 (rem (check-sum-upc (reversed-digits candidate)) 10 ))))

;; Exercise 10
(def number-checker
  (fn [checker candidate divider]
    (zero? (rem (checker (reversed-digits candidate)) divider))))

