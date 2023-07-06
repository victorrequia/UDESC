import matplotlib.pyplot as plt
import numpy as np
from skimage.io import imread
from skimage.metrics import mean_squared_error as mse
from skimage.metrics import structural_similarity as ssim


def fourier_masker_ver(image, i):
    f_size = 15
    dark_image_grey_fourier = np.fft.fftshift(np.fft.fft2(image))
    dark_image_grey_fourier[:590  , 955:970] = i
    dark_image_grey_fourier[-590: , 955:970] = i

    fig, ax = plt.subplots(1,2,figsize=(20,20))
    ax[0].imshow(np.log(abs(dark_image_grey_fourier)), cmap='gray')
    ax[0].set_title('Máscara de Fourier', fontsize = f_size)

    ax[1].imshow(abs(np.fft.ifft2(dark_image_grey_fourier)), cmap='gray')
    ax[1].set_title('Tranformação Final', fontsize = f_size)
    plt.show()

    # SSIM e MSE
    result = np.abs(dark_image_grey_fourier)
    result2 = result.astype(np.uint8)
    ssimValue = ssim(image, result2)
    mseValue = mse(image, result2)

    print("SSIM VERTICAL:", ssimValue)
    print("MSE VERTICAL:", mseValue)

def fourier_masker_hor(image, i):
    f_size = 15
    dark_image_grey_fourier = np.fft.fftshift(np.fft.fft2(image))
    dark_image_grey_fourier[600:615 , :955] = i
    dark_image_grey_fourier[600:615 , -955:] = i


    fig, ax = plt.subplots(1,2,figsize=(15,15))
    ax[0].imshow(np.log(abs(dark_image_grey_fourier)), cmap='gray')
    ax[0].set_title('Máscara de Fourier', fontsize = f_size)

    ax[1].imshow(abs(np.fft.ifft2(dark_image_grey_fourier)), cmap='gray')
    ax[1].set_title('Tranformação Final', fontsize = f_size)
    plt.show()

    # SSIM e MSE
    result = np.abs(dark_image_grey_fourier)
    result2 = result.astype(np.uint8)
    ssimValue = ssim(image, result2)
    mseValue = mse(image, result2)

    print("SSIM HORIZONTAL:", ssimValue)
    print("MSE HORIZONTAL:", mseValue)

def fourier_masker_ver_hor(image, i):
    f_size = 15
    dark_image_grey_fourier = np.fft.fftshift(np.fft.fft2(image))
    dark_image_grey_fourier[600:610 , :950] = i
    dark_image_grey_fourier[600:610 , -950:] = i
    dark_image_grey_fourier[:600  , 955:965] = i
    dark_image_grey_fourier[-590: , 955:965] = i

    fig, ax = plt.subplots(1,2,figsize=(15,15))
    ax[0].imshow(np.log(abs(dark_image_grey_fourier)), cmap='gray')
    ax[0].set_title('Máscara de Fourier', fontsize = f_size)

    ax[1].imshow(abs(np.fft.ifft2(dark_image_grey_fourier)), cmap='gray')
    ax[1].set_title('Tranformação Final', fontsize = f_size)
    plt.show()
    
    # SSIM e MSE
    result = np.abs(dark_image_grey_fourier)
    result2 = result.astype(np.uint8)
    ssimValue = ssim(image, result2)
    mseValue = mse(image, result2)

    print("SSIM VERTICAL E HORIZONTAL:", ssimValue)
    print("MSE VERTICAL E HORIZONTAL:", mseValue)

# MAIN
dark_image = imread('A/folhas1_Reticulada.jpg')

fourier_masker_ver(dark_image, 1)

fourier_masker_hor(dark_image, 1)

fourier_masker_ver_hor(dark_image, 1)
