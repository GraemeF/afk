(ns afk.battle
  (:gen-class ))

(defn lose-health [actor amount]
  (update-in actor [:health ] #(- % amount)))