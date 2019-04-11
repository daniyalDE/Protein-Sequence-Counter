total="10"
start="1"
end="4"
while [ $end -le $total ] ; 
do
cut_command="time cut -c $start-$end test.txt > proteins_2";
start=$((start+1)); 
end=$((end+1)); 
iter=$((iter+1)); 
done

