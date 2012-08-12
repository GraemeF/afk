(ns afk.battle-test
  (:use clojure.test
        afk.battle))

(deftest lose-some-health
  (let [actor {:health 100}]
    (is (= 95
          (:health (lose-health actor 5))))))