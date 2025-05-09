import os
os.environ['KMP_DUPLICATE_LIB_OK']='True'
import tkinter as tk
from tkinter import filedialog
from tkinter.filedialog import askopenfile
from PIL import Image, ImageTk
import easyocr
my_w = tk.Tk()
my_w.geometry("600x800")  # Size of the window 
my_w.title('TechieYan Technologies')
my_font1=('times', 18, 'bold')


reader = easyocr.Reader(['en'])
filename = ""
def upload_file():
    global img,filename
    f_types = [('Jpg Files', '*.jpg'),('PNG Files','*.png')]  
    filename = filedialog.askopenfilename(filetypes=f_types)
    img = ImageTk.PhotoImage(file=filename)
    b2 =tk.Button(my_w,image=img) # using Button 
    b2.grid(row=3,column=1)

    
def text():
    a = ""
    output = reader.readtext(filename)
    for x in range(len(output)):
        a+=output[x][1]
    print(a)
        
    label2 = tk.Label(my_w,text = a,width = 100, height = 4,fg = "blue")
    
    label2.grid(column = 1, row = 23)


l1 = tk.Label(my_w,text='Select image to perform OCR',width=30,font=my_font1)  
l1.grid(row=1,column=1)
b1 = tk.Button(my_w, text='Upload File', 
   width=20,command = lambda:upload_file())
b1.grid(row=2,column=1) 

button_text = tk.Button(my_w,
                        text = "Read text",
                        command = text)



button_exit = tk.Button(my_w,
                    text = "Exit",
                    command = my_w.destroy)

button_text.grid(column = 1, row = 13)
button_exit.grid(column = 1,row = 14)



my_w.mainloop()  # Keep the window open