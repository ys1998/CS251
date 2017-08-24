#/bin/bash

list=$(cat $1 | grep -o "\<[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\>[\.]*[0-9]*")
#list=$( cat $1 | grep -oE "\<[0-9]+(\.[0-9]+){3}[^.]\>"

for ip in $list
do
  if [ $(echo $ip | grep -o "\." | wc -l) -eq 4 ] && [ $(echo $ip | grep -o "\.$" | wc -l) -eq 0 ] 
  then
    continue
  fi

  w=$(echo $ip | cut -d. -f 1);
  if [ $w -gt 255 ] 
  then
    continue
  fi

  x=$(echo $ip | cut -d. -f 2);
  if [ $x -gt 255 ]
  then
    continue;
  fi

  y=$(echo $ip | cut -d. -f 3);
  if [ $y -gt 255 ]
  then
    continue;
  fi

  z=$(echo $ip | cut -d. -f 4);
  if [ $z -gt 255 ]
  then
    continue;
  fi

  if [ $w -gt 247 ]
  then
    echo $ip "Not Defined"
  elif [ $w -gt 239 ]
  then
    echo $ip "E"
  elif [ $w -gt 223 ]
  then
    echo $ip "D"
  elif [ $w -gt 191 ]
  then
    echo $ip "C"
  elif [ $w -gt 127 ]
  then
    echo $ip "B"
  else
    echo $ip "A"
  fi
done
echo ""
