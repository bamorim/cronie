(ns cronies.parser
  (:require [clojure.string :as s]))

(defn parse-term [term]
  (let [[word start end step]
        (re-find #"(\d+)\-(\d+)\/(\d+)" term)
        {:start start :end end :step step})))


(defn parse-cron [cron]
  (as-> cron x
    (s/split x #" ")
    (map parse-term x)))

#check condp for different regex cases

(parse-cron "* * * * * ")
