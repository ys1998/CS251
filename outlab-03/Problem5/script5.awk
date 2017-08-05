#!/bin/awk -f
BEGIN {
	FS = ",";
	OFS = ",";
	city[""] = 0;
	present[""]=0;
	cntr=0;
}

{
	if($0!=""){
		city[$2] += $3;
		if(present[$2]==0){
			city_name[cntr]=$2;
			present[$2]=1;
		}
		cntr++;
	}
}

END {
	sort(city_name,cntr);
	for (i=0;i<cntr;++i){
		if (city_name[i] != ""){
			temp_city=city_name[i];
			print city_name[i], city[temp_city];
		}
	}
}
function sort(a,n,    j,temp){
	# n is length
	# j and temp are variables to be used only locally
	# bubble sort implemented
	for(i=0;i<n;++i){
		for(j=i+1;j<n;++j){
			if(toupper(a[j])<toupper(a[j-1])){
				temp=a[j-1]; a[j-1]=a[j]; a[j]=temp;
			}
		}
	}
}

