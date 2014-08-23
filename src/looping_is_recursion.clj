(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc base exp]
                 (if (zero? exp)
                   acc
                   (recur (* acc base) base (dec exp))))]
    (helper 1 base exp)))

(defn last-element [a-seq]
  (if (empty? (rest a-seq))
    (first a-seq)
    (recur (rest a-seq))))

(defn seq= [seq1 seq2]
  (cond
   (and (empty? seq1) (empty? seq2))   true
   (or  (empty? seq1) (empty? seq2))   false
   (not (= (first seq1) (first seq2))) false
   :else                               (recur (rest seq1) (rest seq2))))

(defn find-first-index [pred a-seq]
  (loop [n    0
         coll a-seq]
    (cond
     (empty? coll)       nil
     (pred (first coll)) n
     :else               (recur (inc n) (rest coll)))))

(defn avg [a-seq]
  (loop [sum   0
         count 0
         coll  a-seq]
    (if (empty? coll)
      (if (zero? count)
        0
        (/ sum count))
      (recur (+ sum (first coll)) (inc count) (rest coll)))))

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

