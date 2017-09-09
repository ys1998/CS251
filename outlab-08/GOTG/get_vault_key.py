import urllib.parse
import urllib.request
#import requests
url = 'https://www.cse.iitb.ac.in/~rohitrango/outlab/entrance.php'
login_data={'identity' : 'Star-Lord',
        'password' : 'TheOrbIsMine'}

data=urllib.parse.urlencode(login_data)
data=data.encode('ascii')
#req = urllib.request.Request(
#    url, 
#    data=data, 
#    headers={
#        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.47 Safari/537.36'
#    }
#)
#r=urllib.request.urlopen(req)
r = urllib.request.urlopen(url, data)
print(r.read())