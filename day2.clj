(ns laat.aoc2021.day2
  (:require
   [aocd.core :as aoc]
   [clojure.string :as str])
  (:gen-class))

(def example "forward 5\ndown 5\nforward 8\nup 3\ndown 8\nforward 2")
(def input (aoc/input 2021 2))

(defn parse [in]
  (->> in
       str/split-lines
       (map #(str/split % #" "))
       (map (fn [[k v]] [(keyword k) (read-string v)]))))

(->> input
     parse
     (reduce (fn [m [cmd x]]
               (case cmd
                 :forward (update m :horizontal + x)
                 :down (update m :depth + x)
                 :up (update m :depth - x)))
             {:horizontal 0 :depth 0})
     (#(* (:horizontal %1) (:depth %1))))
;; => 1524750

(->> input
     parse
     (reduce (fn [m [cmd x]]
               (case cmd
                 :forward (-> m
                              (update :horizontal + x)
                              (update :depth + (* (:aim m) x)))
                 :down (update m :aim + x)
                 :up (update m :aim - x)))
             {:horizontal 0 :depth 0 :aim 0})
     (#(* (:horizontal %1) (:depth %1))))
;; => 1592426537
