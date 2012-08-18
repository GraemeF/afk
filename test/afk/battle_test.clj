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