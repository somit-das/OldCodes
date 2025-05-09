# Give me different type of media queries for responsive structure

Here’s a comprehensive guide to commonly used **media queries** for creating a responsive website structure. These queries adapt your layout to different screen sizes and device types.

---

### **Basic Media Query Syntax**

```css
@media (condition) {
  /* CSS rules here */
}
```

---

### **1. Device-Based Queries**

#### **For Mobile Devices**

```css
/* Small phones (portrait and landscape) */
@media (max-width: 480px) {
  body {
    font-size: 14px;
  }
}

/* Medium phones */
@media (max-width: 768px) {
  body {
    font-size: 16px;
  }
}
```

#### **For Tablets**

```css
/* Portrait tablets */
@media (min-width: 768px) and (max-width: 1024px) {
  body {
    font-size: 18px;
  }
}
```

#### **For Laptops**

```css
@media (min-width: 1024px) and (max-width: 1366px) {
  body {
    font-size: 20px;
  }
}
```

#### **For Desktops**

```css
/* Large desktops */
@media (min-width: 1366px) {
  body {
    font-size: 22px;
  }
}
```

---

### **2. Orientation-Based Queries**

#### **Portrait Mode**

```css
@media (orientation: portrait) {
  .container {
    flex-direction: column;
  }
}
```

#### **Landscape Mode**

```css
@media (orientation: landscape) {
  .container {
    flex-direction: row;
  }
}
```

---

### **3. Retina or High-Resolution Displays**

```css
@media (-webkit-min-device-pixel-ratio: 2), (min-resolution: 192dpi) {
  .icon {
    background-image: url('icon@2x.png');
  }
}
```

---

### **4. Aspect Ratio**

#### **Wide Screens**

```css
@media (min-aspect-ratio: 16/9) {
  .video {
    width: 80%;
  }
}
```

#### **Square Screens**

```css
@media (max-aspect-ratio: 1/1) {
  .box {
    width: 100%;
  }
}
```

---

### **5. Dark Mode Preference**

```css
@media (prefers-color-scheme: dark) {
  body {
    background-color: #121212;
    color: #ffffff;
  }
}
```

---

### **6. Custom Breakpoints**

#### **Example Breakpoints**

```css
/* Extra small devices (phones, 0px to 576px) */
@media (max-width: 576px) {
  .header {
    font-size: 12px;
  }
}

/* Small devices (tablets, 576px to 768px) */
@media (min-width: 576px) and (max-width: 768px) {
  .header {
    font-size: 14px;
  }
}

/* Medium devices (landscape tablets, 768px to 992px) */
@media (min-width: 768px) and (max-width: 992px) {
  .header {
    font-size: 16px;
  }
}

/* Large devices (laptops/desktops, 992px to 1200px) */
@media (min-width: 992px) and (max-width: 1200px) {
  .header {
    font-size: 18px;
  }
}

/* Extra large devices (large desktops, 1200px and above) */
@media (min-width: 1200px) {
  .header {
    font-size: 20px;
  }
}
```

---

### **7. Hover and Pointer Media Queries**

#### **Devices with Hover Capability**

```css
@media (hover: hover) {
  .button:hover {
    background-color: blue;
  }
}
```

#### **Devices without Hover Capability**

```css
@media (hover: none) {
  .button {
    background-color: green;
  }
}
```

---

### **8. Print-Specific Queries**

```css
@media print {
  body {
    font-size: 12px;
    color: black;
    background: white;
  }
}
```

---

### **9. Grid or Flexbox Tweaks for Responsive Layouts**

#### **Two-Column Layout for Larger Screens**

```css
@media (min-width: 768px) {
  .container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 20px;
  }
}
```

#### **Single-Column Layout for Smaller Screens**

```css
@media (max-width: 768px) {
  .container {
    display: flex;
    flex-direction: column;
  }
}
```

---

These media queries allow you to build responsive and adaptive structures that look great across all devices. Let me know if you'd like specific examples or optimizations!
