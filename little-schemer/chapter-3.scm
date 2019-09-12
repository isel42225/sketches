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

(define insertR 
  (lambda (new old lat)
    (cond 
      ((null? lat) '())
      ((eq? old (car lat)) (cons old (cons new (cdr lat))))
      (else 
        (cons (car lat) (insertR new old (cdr lat)))))))

(define insertL
  (lambda (new old lat)
    (cond 
      ((null? lat) '())
      ((eq? old (car lat)) (cons new lat))
      (else 
        (cons (car lat) (insertL new old (cdr lat)))))))

(define subst
  (lambda (new old lat)
    (cond
      ((null? lat) '())
      ((eq? old (car lat)) (cons new (cdr lat)))
      (else 
        (cons (car lat) (subst new old (cdr lat)))))))

(define subst2 
  (lambda (new o1 o2 lat)
    (cond 
      ((null? lat) '())
      ((eq? o1 (car lat)) (cons new (cdr lat)))
      ((eq? o2 (car lat)) (cons new (cdr lat)))
      (else 
        (cons (car lat) (subst2 new o1 o2 (cdr lat)))))))

(define multirember
  (lambda (a lat)
    (cond
      ((null? lat) '())
      ((eq? a (car lat)) (multirember a (cdr lat)))
      (else 
        (cons (car lat) (multirember a (cdr lat)))))))

  (define multiinsertR
    (lambda (new old lat)
      (cond 
        ((null? lat) '())
        (else
          (cond 
            ((eq? old (car lat)) 
              (cons old 
                (cons new (multiinsertR new old (cdr lat)))))
            (else 
              (cons (car lat) (multiinsertR new old (cdr lat))))))))