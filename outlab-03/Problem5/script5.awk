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
		check=tolower($2);
		city[check] += $3;
		if(present[check]==0){
			city_name[cntr]=check;
			present[check]=1;
		}
		cntr++;
	}
}

END {
	sort(city_name,cntr);
	for (i=0;i<cntr;++i){
		if (city_name[i] != ""){
			temp_city=city_name[i];
			print toupper(substr(city_name[i],1,1)) substr(city_name[i],2), city[temp_city];
		}
	}
}
function sort(a,n,    j,temp){
	# n is length
	# j and temp are variables to be used only locally
	# bubble sort implemented
	for(i=0;i<n;++i){
		for(j=i+1;j<n;++j){
			if(a[j]<a[j-1]){
				temp=a[j-1]; a[j-1]=a[j]; a[j]=temp;
			}
		}
	}
}

