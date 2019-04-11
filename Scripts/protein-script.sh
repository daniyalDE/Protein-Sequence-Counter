total="$(wc -c pre-processed_aa.fasta|cut -d ' ' -f1)"
start="1"
end="4"
time while [ $end -le $total ] ; 
do cut -c $start-$end pre-processed_aa.fasta >> proteins_2; 
start=$((start+1)); end=$((end+1)); 
iter=$((iter+1)); 
done

