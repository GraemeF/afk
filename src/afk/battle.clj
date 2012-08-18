(ns afk.battle
  (:gen-class ))

(defn lose-health [actor amount]
  {:pre [(> amount 0)]}
  (update-in actor [:health ] #(- % (min % amount))))