
# WESTERN GOVERNORS UNIVERSITY <br><sup>D287 – JAVA FRAMEWORKS</sup>

## <ins>Changes</ins>
<!-- TOC -->
  * [Part C](#emc-customize-the-html-user-interface-for-your-customers-application-the-user-interface-should-include-the-shop-name-the-product-names-and-the-names-of-the-partsem-a-nameca)
    * [<strong>File: mainscreen.html<strong>](#strongfile-mainscreenhtmlstrong)
  * [Part D](#emd-add-an-about-page-to-the-application-to-describe-your-chosen-customers-company-to-web-viewers-and-include-navigation-to-and-from-the-about-page-and-the-main-screenem)
    * [<strong>File: mainscreen.html<strong>](#strongfile-mainscreenhtmlstrong-1)
    * [<strong>File: AboutPageController.java<strong>](#strongfile-aboutpagecontrollerjavastrong)
    * [<strong>File: about.html<strong>](#strongfile-abouthtmlstrong)
<!-- TOC -->

---
### <em>C) Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.</em> <a name="C"></a>
### <strong>File: mainscreen.html<strong>


Line 14 &rarr; renamed shop title to "MAXTEK"
<br>Line 15 &rarr; added mouse image to favicon</br>
```html
<title>MAXTEK</title>
<link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
```

Lines 16 - 61 &rarr; added for styling of page (CSS)
```html
 <style>
        body{
            background-color: #3f5a88;
            color: #e2f8f3;
            margin-bottom: 5vh;
            font-weight: bold;
        }
        h1,h2{
            color: white;
        }
        hr{
            background-color: #e2f8f3;
            opacity: .5;
        }
        .top{
            position: relative;
            width: 100vw;
            left:calc(-50vw + 50%);
            background-color: #1e3a76;

        }
        .filter-box {
            border: none;
            appearance: none;
            background: #a5c9d5;
            padding: 2px;
            border-radius: 4px;
            width: 250px;
            outline: none;
        }
        .main-header{
            padding-left: 50vw;
            padding-top: 4px;
        }
        table{
            background-color: #698d9b;
            border-radius: 2px;
            box-shadow: 0px 0px 0px 5px #a5c9d5;
        }


       input[type=text]{
            color: #1e1e76;
            font-weight: bold;
       }
    </style>
```


Lines 67 - 70 &rarr; added div container for top section of page
<br>Line 68 &rarr; changed header to MAXTEK and included a class for styling </br>
```html
<div class = "top">
    <h1 class = "main-header">MAXTEK</h1>
    <hr>
</div>
```

Line 71 &rarr; changed header from "Parts" to "System Components"
```html
<h2>Hardware</h2>
```

Line 73 &rarr; changed input to include "filter-box" class for styling
```html
Filter: <input type="text" name="partkeyword" id="partkeyword" class = "filter-box" size="50" th:value="${partkeyword}" required />
```
Lines 80 - 81 &rarr; changed inhouse and outsourced buttons' text to MAXTEK and 3rd party hardware respectively
```html
<a th:href="@{/showFormAddInPart}" class="btn btn-primary btn-sm mb-3">Add MAXTEK Hardware</a>
<a th:href="@{/showFormAddOutPart}" class="btn btn-primary btn-sm mb-3">Add 3rd Party Hardware</a>
```
Lines 97 - 98 &rarr; changed text in delete part prompt to say "item" instead of "part"
```html
<a th:href="@{/deletepart(partID=${tempPart.id})}" class="btn btn-primary btn-sm mb-3"
                   onclick="if(!(confirm('Are you sure you want to delete this item?')))return false">Delete</a>
```
Line 103 &rarr; changed header from "Products" to "Prebuilt Systems"
```html
<h2>Prebuilt Systems</h2>
```

Line 105 &rarr; changed input to include "filter-box" class for styling
```html
Filter: <input type="text" name="productkeyword" id="productkeyword" class = "filter-box" size="50" th:value="${productkeyword}" required />
```

Line 117 &rarr; changed button text to "Add Prebuilt"
```html
<a th:href="@{/showFormAddProduct}" class="btn btn-primary btn-sm mb-3">Add Prebuilt</a>
```
Lines 133 - 134 &rarr; changed text in delete product prompt to say "prebuilt" instead of "product"
```html
<a th:href="@{/deleteproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3"
                   onclick="if(!(confirm('Are you sure you want to delete this prebuilt?')))return false">Delete</a>
```
---

### <em>D) Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.</em>
### <strong>File: mainscreen.html<strong>


Lines 46 - 49 &rarr; adjusted off-centered header 
```css
 .main-header{
    text-align: center;
    padding-top: 4px;
}
```
Lines 61 - 71 &rarr; added styling for "About Us" button
```css
 .about-btn-container, .abt-btn{
    display: block;
    border-radius: 3px;
    text-align: center;
    width: 10vw;
    background-color: #4d8abe;
    margin-left: auto;
    text-decoration: none;
    color: white;
    user-select: none;
}
```
Lines 82 - 84 &rarr; added a button that links to "About Us page"
```html
<div class="about-btn-container">
        <a href="/about" class="abt-btn">About Us</a>
</div>
```
<br>

### <strong>File: AboutPageController.java<strong>


Lines 1 - 12 &rarr; added new controller file with @GetMapping controller to create access to "About" page
```java
package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutPageController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
```
<br>

### <strong>File: about.html<strong>


Lines 1 - 97 &rarr; added a new about.html page with minor similar elements to mainscreen.html and links to and from mainscreen
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .top{
            background-color: #1e3a76;
            color: white;
        }
        hr{
            opacity: .5;
        }
        br{user-select: none}
        .main-header{
            text-align: center;
            padding-top: 4px;
            user-select: none;
        }
        body{
            background-color: #3f5a88;
        }
        .boundary{
            min-height: 85vh; /* minimum height = screen height */
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .centered-box{
            min-height: 75vh;
            min-width: 40vw;
            max-height: 75vh;
            max-width: 40vw;
            border-radius: 2px;
            box-shadow: 0px 0px 0px 10px #698d9b;
            background-color: #e2f8f3;
        }
        .about-text{
            text-align: center;
            color: #2d3c67;
            padding-left: 6px;
            padding-right: 6px;
        }
        .btn{
            display: block;
            text-align: center;
            width: 10vw;
            background-color: #4d8abe;
            color: white;
            margin-top: auto;
            margin-left: auto;
            margin-right: auto;
        }
        .btn-container {
            display: flex;
            flex-direction: column;
            height: 15vh;
        }
    </style>
    <title>MAXTEK</title>
    <link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
</head>
<body>
<div class="top">
    <h1 class="main-header">MAXTEK</h1>
    <hr>
</div>
<div class = "container">
    <div class = "boundary">
        <div class = "centered-box">
            <div>
                <h2 class = "about-text"><strong><ins>ABOUT US</ins></strong></h2>
                <p class = "about-text">We are a team engineers with a passion for designing and building computer hardware. Not only do we manufacture our specially designed hardware in-house, but we also have connections with major tech companies allowing us to put our personal spin on the latest hardware.</p>
                <br>
                <h2 class = "about-text"><strong><ins>WHAT WE OFFER</ins></strong></h2>
                <p class = "about-text">We provide everything you need for your next PC build. Anything from a few ounces of thermal paste to shiny new GPUs, whatever you're looking for we can provide. But if you're looking for something more simple, browse our pre-made custom-builds ready to be shipped.</p>
                <br>
                <h2 class = "about-text"><strong><ins>COMING SOON...</ins></strong></h2>
                <p class = "about-text">Want something a little more unique, but don't have the time? We are soon launching our Special Builds program where our team assembles your machine for you. Just pick the parts and we do the job. Easy and hassle-free.</p>
            </div>
            <br>
            <div class="btn-container">
                <a href="/mainscreen" class="btn">Go Back</a>
            </div>


        </div>
    </div>

</div>
</body>
</html>
```
---
### <em>E) Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.</em>
### <strong>File: BootStrapData.java<strong>

Lines 45 - 80 &rarr; added 5 new prebuilts (products) to repository 
```java
 if(productRepository.count() == 0) {
    Product prebuiltA = new Product();
    prebuiltA.setName("MAXTEK Cyber i77 Platinum");
    prebuiltA.setInv(5);
    prebuiltA.setPrice(2699.99);
    prebuiltA.setId(1);
    productRepository.save(prebuiltA);

Product prebuiltB = new Product();
    prebuiltB.setName("MAXTEK Tekki gs20");
    prebuiltB.setInv(9);
    prebuiltB.setPrice(1999.99);
    prebuiltB.setId(2);
    productRepository.save(prebuiltB);

Product prebuiltC = new Product();
    prebuiltC.setName("MAXTEK Cyber i66 Gold");
    prebuiltC.setInv(3);
    prebuiltC.setPrice(1199.99);
    prebuiltC.setId(3);
    productRepository.save(prebuiltC);

Product prebuiltD = new Product();
    prebuiltD.setName("MAXTEK Cyber i55");
    prebuiltD.setInv(17);
    prebuiltD.setPrice(999.99);
    prebuiltD.setId(4);
    productRepository.save(prebuiltD);

Product prebuiltE = new Product();
    prebuiltE.setName("MAXTEK Tekki gs20 START");
    prebuiltE.setInv(30);
    prebuiltE.setPrice(499.99);
    prebuiltE.setId(5);
    productRepository.save(prebuiltE);
}
```

Lines 82 - 117 &rarr; added two MAXTEK hardware products and three 3rd party hardware products

```java
    if(inhousePartRepository.count() == 0) {
        InhousePart tower = new InhousePart();
        tower.setName("MAXTEK Stealth ATX/Micro ATX ARGB");
        tower.setInv(100);
        tower.setId(255);
        tower.setPrice(97.59);
        inhousePartRepository.save(tower);

        InhousePart cooler = new InhousePart();
        cooler.setName("MAKTEK FLEX AIO Water Cooler (360mm)");
        cooler.setInv(67);
        cooler.setId(1243);
        cooler.setPrice(114.47);
        inhousePartRepository.save(cooler);
    }
    if(outsourcedPartRepository.count() == 0){
        OutsourcedPart gpu =  new OutsourcedPart();
        gpu.setName("Avid-N STX 7300-S");
        gpu.setInv(200);
        gpu.setId(50);
        gpu.setPrice(1859.79);
        outsourcedPartRepository.save(gpu);

        OutsourcedPart cpu =  new OutsourcedPart();
        cpu.setName("notel core j56S");
        cpu.setInv(137);
        cpu.setId(890);
        cpu.setPrice(323.49);
        outsourcedPartRepository.save(cpu);

        OutsourcedPart mobo =  new OutsourcedPart();
        mobo.setName("misi motherboard MEG X4390-C");
        mobo.setInv(790);
        mobo.setId(577);
        mobo.setPrice(129.99);
        outsourcedPartRepository.save(mobo);

```
---
