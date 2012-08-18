(ns afk.battle
  (:gen-class ))

(defn lose-health [actor amount]
  {:pre [(> amount 0)]
   :post [(>= (:health %) 0)]}
  (update-in actor [:health ] #(- % (min % amount))))

(defn hit [actor target]
  (lose-health target ((get-in actor [:weapon :damage]))))