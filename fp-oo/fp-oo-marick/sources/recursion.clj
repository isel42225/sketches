;; Exercise 1
(def factorial
  (fn [n]
    (if (or (= n 1)
            (= n 0))
      1
      (* n
         (factorial (dec n))))))

;; Exercise 2
(def factorial2
  (fn [n acc]
    (if (or (= n 0)
            (= n 1))
      acc
      (factorial2 (dec n) (* n acc)))))

;; Exercise 3
(def recursive-function-1
  (fn [seq acc]
    (if (empty? seq)
      acc
      (recursive-function-1 (rest seq) (+ (first seq) acc)))))

;; Exercise 4
(def recursive-function-2
  (fn [seq acc]
    (if (empty? seq)
      acc
      (recursive-function-2 (rest seq) (* (first seq) acc)))))

(def recursive-function
  (fn [f seq acc]
    (if (empty? seq)
      acc
      (recursive-function f (rest seq) (apply f [(first seq) acc])))))

;; Exercise 5
(def keyword-to-key-with-same-val
  (fn [keyword map]
    (assoc map keyword 0)))

(def keyword-to-key-with-inc-val
  (fn [keyword map]
    (assoc map keyword (count map))))

