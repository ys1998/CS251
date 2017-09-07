import numpy
def closedForm():
	data=numpy.genfromtxt('train.csv',delimiter=",")
	x=data[1:,:-1]
	x[:,0]=1
	# print x[0,:]
	x[:,5]=x[:,5]**2
	x[:,6]=x[:,6]**2
	# x=numpy.delete(x,6,1)
	# print x[0,:]
	x[:,9]=numpy.log(x[:,9])
	x[:,13]=numpy.log(x[:,13])
	# print x[0,:]
	y=numpy.log(data[1:,-1]).transpose()
	# print y
	w=numpy.matmul(numpy.matmul(numpy.linalg.inv(numpy.matmul(x.transpose(),x)),x.transpose()),y)
	return w

