(ns laat.aoc2021.day1
  (:require [clojure.string :refer [split-lines]])
  (:gen-class))

(->> "day1.txt"
     slurp
     split-lines
     (map bigint)
     (partition 2 1)
     (filter #(apply < %))
     count)
;; => 1387

(->> "day1.txt"
     slurp
     split-lines
     (map bigint)
     (partition 3 1)
     (map #(apply + %))
     (partition 2 1)
     (filter #(apply < %))
     count)
;; => 1362
