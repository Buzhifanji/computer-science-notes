(define (bigSum x y z)
    (if (> x y)
        (if (> y z)
            (+ x y)
            (+ x z)
        )
        (if (> x z)
            (+ y x)
            (+ y z)
        )
    )
)
(display (bigSum 2 4 6))
(display "end")
(exit)