import zipfile

zfile=zipfile.ZipFile('final_message.zip')
passwords = open('words.txt')
for line in passwords.readlines():
    password = line.strip()
    try:
        zfile.extractall(pwd=password.encode('cp850','replace'))
        print(password)
        exit(0)
    except Exception as e:
        pass
zfile.close()
