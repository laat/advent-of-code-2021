(ns laat.aoc2021.day1
  (:require
   [aocd.core :as aoc]
   [clojure.string :refer [split-lines]])
  (:gen-class))

(def example "199\n200\n208\n210\n200\n207\n240\n269\n260\n263\n")
(def input (aoc/input 2021 1))

(->> input
     split-lines
     (map bigint)
     (partition 2 1)
     (filter #(apply < %))
     count)
;; => 1387

(->> input
     split-lines
     (map bigint)
     (partition 3 1)
     (map #(apply + %))
     (partition 2 1)
     (filter #(apply < %))
     count)
;; => 1362
