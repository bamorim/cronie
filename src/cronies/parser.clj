(ns cronies.parser
  (:require [clojure.string :as s]))

(defn parse-term [term]
  (condp re-find term
    #"(\d{1,2})\-(\d{1,2})\/(\d{1,2})" :>> #(hash-map :start (nth % 1) :end (nth % 2) :step (nth % 3))
    #"(\d{1,2})\-(\d{1,2})" :>> #(hash-map :start (nth % 1) :end (nth % 2) :step nil)
    #"(\d{1,2}|\*)\/(\d{1,2})" :>> #(hash-map :start (nth % 1) :end nil :step (nth % 2))
    #"(\d{1,2}|\*)" :>> #(hash-map :start (nth % 1) :end nil :step nil)))


(defn parse-cron [cron]
  (as-> cron x
    (s/split x #" ")
    (map parse-term x)))
