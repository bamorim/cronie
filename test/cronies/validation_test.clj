(ns cronies.validation-test
  (:require [clojure.test :refer :all]
            [cronies.validation :as v]
            [clj-time.core :as t]))

(def valid? cronies.validation/valid?)

(def star-cron [
                 [0 59 1]
                 [0 23 1]
                 [1 31 1]
                 [1 12 1]
                 [1 7 1]])

(def even-minute-cron (assoc star-cron 0 [0 59 2]))
(def even-minute-hour-cron (-> star-cron
                               (assoc 0 [0 59 2])
                               (assoc 1 [0 23 2])))

(def odd-minute-even-hour-time (t/date-time 2020 1 13 20 23))
(def even-minute-odd-hour-time (t/date-time 2020 1 13 21 22))
(def even-minute-even-hour-time (t/date-time 2020 1 13 20 22))

(deftest valid-test
  (testing "star cron validates every date"
    (is
     (= 
      true 
      (v/valid? (t/now) star-cron))))
  (testing "Every two minutes should fail on odd minutes"
    (is
     (=
      false
      (v/valid? odd-minute-even-hour-time even-minute-cron))))
  (testing "Even minute"
    (is
     (=
      true
      (v/valid? even-minute-even-hour-time even-minute-cron))))
  (testing "Even even fail 1"
    (is
     (=
      false
      (v/valid? odd-minute-even-hour-time even-minute-hour-cron))))
  (testing "Even even fail 2"
    (is
     (=
      false
      (v/valid? even-minute-odd-hour-time even-minute-hour-cron))))
  (testing "Even even ok 1"
    (is
     (=
      true
      (v/valid? even-minute-even-hour-time even-minute-hour-cron)))))