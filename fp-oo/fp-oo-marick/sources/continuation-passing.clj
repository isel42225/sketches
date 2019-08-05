;; Exercise 1
;; Convert	this	into	continuation-passing	style:
;(let	[a	(concat	'(a	b	c)	'(d	e	f))
;							b	(count	a)]
;			(odd?	b))
(-> '(a b c)
     (concat '(d e f))
     count
     odd?)

;; Exercise 3
;Convert	this	into	continuation-passing	style:
;	(->	3
; 			(+	2)
;				inc)
(-> 3
    ((fn [value] (+ value 2)))
    ((fn [v] (inc v))))