; Is an atom if not a list and not null
(define  atom? 
  (lambda  (x) 
    (and  (not  (pair? x)) (not (null? x)))))

; Is a list of atoms?
(define lat?
  (lambda (l) 
    (cond 
      ((null? l)  #t) ; Ask question (null? l), If Yes return #t , Else go to next question
      ((atom? (car l)) (lat? (cdr  l))) ; If l is atom ask if rest of list is also atom
      (else #f))))

; Is 'a a member of a list of atoms?
(define my-member?
	(lambda (a lat)
		(cond
			((null? lat) #f)
			((eq? a (car lat)) #t)
			(else (member? a (cdr lat))))))

(define  member? 
	(lambda (a  lat) 
		(cond 
			((null? lat)  #f) 
			(else (or (eq? (car  lat)  a) 
			(member? a (cdr  lat))))))) 