; Remove a member, a, of a list if a exists 
; and return the list without that member.
(define rember 
	(lambda (a  lat) 
		(cond 
			(( null? lat)  '()) 
			((eq? (car  lat)  a)  (cdr  lat)) 
			(else (cons  (car  lat) (rember  a (cdr  lat))))))) 
			
(define firsts 
	(lambda (l)
		(cond
			((null? l) '())
			(else (cons (car (car lat)) (firsts (cdr l)))))))