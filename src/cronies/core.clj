(ns cronies.core)

; node: (start end step)
; cron: (minutes hour day_of_month month day_of_week)

(defn parse
  "Parses a cron string into a map of maps"
  [_string]
  {})

(defn step
  "Returns the next plausible date time to be tested given a datetime and a cron"
  [dt _cron]
  [dt])

(defn test_cron
  "Checks if a datetime is valid given a cron"
  [_dt _cron]
  false)