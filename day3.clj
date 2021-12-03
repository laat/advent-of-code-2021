(ns laat.aoc2021.day3
  (:require
   [aocd.core :as aoc]
   [clojure.string :as str])
  (:gen-class))

(def example "00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010")
(def input (aoc/input 2021 3))

(defn transpose [m] (apply mapv vector m))

(->> input
     str/split-lines
     transpose
     (map (fn [xs] (->> xs frequencies (sort-by val) (map first))))
     transpose
     (map #(Long/parseLong (apply str %) 2))
     (apply *))
;; => 4139586
