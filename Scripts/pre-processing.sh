cat uniref90_infl.fasta |sed '/>UniRef90/d'|tr -d '\n'> ~/storage/protein-data/pre-processed.fasta
split pre-processed_aa test_ -b 500MB
