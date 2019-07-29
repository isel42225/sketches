(ns I.embedding-functions)

(def make
  (fn [type & args]
    (apply type args)))


;; maps are the way to represent objects in Clojure
;; keys are callable
;; message is a key of :__methods__ map and :__methods__ is a key of object map
(def send-to
  (fn [object message & args]
    (apply (message (:__methods__ object)) object args)))

(def Point
  (fn [x y]
    {:x x,
     :y y
     :__class_symbol__ 'Point
     :__methods__ {
                   :class :__class_symbol__
                   :x :x
                   :y :y
                   :shift (fn [this xinc yinc]
                            (make Point (+ (send-to this :x) xinc)
                                  (+ (send-to this :y) yinc)))}}))
                   :add (fn [this other]
                           (send-to this :shift (send-to other :x)
                                    (send-to other :y)))

