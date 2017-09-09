import numpy as np
import matplotlib.pyplot as plt
def decode():
	data=np.load('message.npy')
	# data is RGB array
	# org_img=plt.imshow(data)
	# plt.show()
	
	# Contrast stretching is done on three channels together
	c_r,d_r=np.min(data[:,:,0]),np.max(data[:,:,0])
	c_g,d_g=np.min(data[:,:,1]),np.max(data[:,:,1])
	c_b,d_b=np.min(data[:,:,2]),np.max(data[:,:,2])
	nd=np.array(data)
	nd[:,:,0]-=c_r;nd[:,:,1]-=c_g;nd[:,:,2]-=c_b;
	nd[:,:,0]*=255/(d_r-c_r);nd[:,:,1]*=255/(d_g-c_g);nd[:,:,2]*=255/(d_b-c_b);
	new_img=plt.imshow(nd)
	plt.savefig('processed_image.png')
	plt.show()


if __name__ == '__main__':
	decode()