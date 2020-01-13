(ns cronies.validation)
(require '[clj-time.core :as t])

(defn valid?
  "Checks if a datetime is valid given a cron"
  [dt cron]
  (let
   [minutes (set (apply range (nth cron 0)))
    hours (set (apply range (nth cron 1)))
    days-of-month (set (apply range (nth cron 2)))
    months (set (apply range (nth cron 3)))
    days-of-week (set (apply range (nth cron 4)))]
    (println "Test")
    (println minutes)
    (and
     (contains? minutes (t/minute dt))
     (contains? hours (t/hour dt))
     (contains? days-of-month (t/day dt))
     (contains? months (t/month dt))
     (contains? days-of-week (t/day-of-week dt)))))