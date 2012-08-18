(ns afk.battle-test
  (:use clojure.test
        afk.battle))

(testing "lose-health"
  (deftest lose-some-health
    (let [actor {:health 100}]
      (is (= 95
            (:health (lose-health actor 5)))))
    )

  (deftest lose-only-positive-amount-of-health
    (let [actor {:health 100}]
      (is (thrown? AssertionError
            (:health (lose-health actor -5)))))
    )

  (deftest lose-all-health-and-then-some
    (let [actor {:health 100}]
      (is (= 0
            (:health (lose-health actor 105)))))
    )
  )

(testing "hit"
  (let [player-hits-mob
        (fn [damage]
          (let [player {:health 100
                        :weapon {:damage (constantly damage)}}
                mob {:health 100}]
            (:health (hit player mob))))]

    (deftest player-hits-mob-for-20
      (is (= 80 (player-hits-mob 20))))

    (deftest player-hits-mob-for-2
      (is (= 98 (player-hits-mob 2))))
    )
  )