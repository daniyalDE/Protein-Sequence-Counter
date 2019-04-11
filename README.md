# Protein-Sequence-Counter

Program in Scala to process big fasta files containing large concatenated strings of protein sequences. Purpose is to find protein sequences of length 4 and check occurance of those sequences. If a substring's occurance is significant it means the protein sequence is a valid sequence.

Scripts folder contains some bash scripts for preprocessing large files for easier distribution in Hadoop/Spark.

Output is appended in csv files containing protein sub strings and the count of their occurance which can be reduced in HDFS.
