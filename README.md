
# University Java Project

## <ins>Changes</ins>
<!-- TOC -->
  * [Part C](#emc-customize-the-html-user-interface-for-your-customers-application-the-user-interface-should-include-the-shop-name-the-product-names-and-the-names-of-the-partsem-a-nameca)
    * [<strong>File: mainscreen.html<strong>](#strongfile-mainscreenhtmlstrong)
  * [Part D](#emd-add-an-about-page-to-the-application-to-describe-your-chosen-customers-company-to-web-viewers-and-include-navigation-to-and-from-the-about-page-and-the-main-screenem)
    * [<strong>File: mainscreen.html<strong>](#strongfile-mainscreenhtmlstrong-1)
    * [<strong>File: AboutPageController.java<strong>](#strongfile-aboutpagecontrollerjavastrong)
    * [<strong>File: about.html<strong>](#strongfile-abouthtmlstrong)
  * [Part E](#eme-add-a-sample-inventory-appropriate-for-your-chosen-store-to-the-application-you-should-have-five-parts-and-five-products-in-your-sample-inventory-and-should-not-overwrite-existing-data-in-the-databaseem)
    * [<strong>File: BootStrapData.java</strong>](#strongfile-bootstrapdatajavastrong)
  * [Part F](#emf-add-a-buy-now-button-to-your-product-list-em)
    * [<strong>mainscreen.html</strong>](#strongfile-mainscreenhtmlstrong-2)
    * [<strong>AddProductController.java</strong>](#strongfile-addproductcontrollerjavastrong)
    * [<strong>purchaseFail.html</strong>](#strongfile-purchasefailhtmlstrong-)
    * [<strong>purchaseSuccess.html</strong>](#strongfile-purchasesuccesshtmlstrong-)
  * [Part G](#emg-modify-the-parts-to-track-maximum-and-minimum-inventory-em-)
    * [<strong>mainscreen.html</strong>](#strongfile-mainscreenhtmlstrong-3)
    * [<strong>InhousePartForm.html</strong>](#strongfile-inhousepartformhtmlstrong)
    * [<strong>OutsourcePartForm.html</strong>](#strongfile-outsourcepartformhtmlstrong)
    * [<strong>InventoryValidator.java</strong>](#strongfile-inventoryvalidatorjavastrong)
    * [<strong>ValidInventory.java</strong>](#strongfile-validinventoryjavastrong)
    * [<strong>Part.java</strong>](#strongfile-partjavastrong)
    * [<strong>BootStrapData.java</strong>](#strongfile-bootstrapdatajavastrong-1)
    * [<strong>application.properties</strong>](#strongfile-applicationpropertiesstrong)
    * [<strong>Additional Changes</strong>](#additional-changes)
      * [<strong>productForm.html</strong>](#strongfile-productformhtmlstrong)
  * [Part H](#emh-add-validation-for-between-or-at-the-maximum-and-minimum-fieldsem)
    * [<strong>MinValidator.java</strong>](#strongfile-minvalidatorjavastrong)
    * [<strong>ValidMin.java</strong>](#strongfile-validminjavastrong)
    * [<strong>MaxValidator.java</strong>](#strongfile-maxvalidatorjavastrong)
    * [<strong>ValidMax.java</strong>](#strongfile-validmaxjavastrong)
    * [<strong>EnufPartsValidator.java</strong>](#strongfile-enufpartsvalidatorjavastrong)
    * [<strong>Part.java</strong>](#strongfile-partjavastrong-1)
    * [<strong>application.properties</strong>](#strongfile-applicationpropertiesstrong-1)
  * [Part I](#emi-add-at-least-two-unit-tests-for-the-maximum-and-minimum-fields-to-the-parttest-class-in-the-test-packageem)
    * [<strong>PartTest.java</strong>](#strongfile-parttestjavastrong)
  * [Part J](#emj-remove-the-class-files-for-any-unused-validators-in-order-to-clean-your-codeem)
    * [<strong>Files Deleted</strong>](#stronginsfiles-removedinsstrong)
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
### <em>F)  Add a “Buy Now” button to your product list. </em>
### <strong>File: mainscreen.html<strong>
Line 149 &rarr; added a "Buy Now" button
```html
<a th:href="@{/buyPrebuilt(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>
```
<br>

### <strong>File: AddProductController.java<strong>
Lines 55 - 66 &rarr; added a "buy prebuilt" method that checks if a prebuilt (product) is in inventory and returns a success/fail page based on available inventory 
```java
@GetMapping("/buyPrebuilt")
    public String buyPrebuilt(@RequestParam("productID") int theId, Model theModel) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product prebuilt=productService.findById(theId);
        int inv = prebuilt.getInv();
        if(inv > 0){
            prebuilt.setInv(inv-1);
            productRepository.save(prebuilt);
            return "purchaseSuccess";}
        else{
            return "purchaseFail";}
    }
```
<br>

### <strong>File: purchaseFail.html<strong> 
Lines 1 - 67 &rarr; added new page that displays failure to purchase if the product had no inventory
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
        h2, h3{
            text-align: center;
            color: white;
            margin-top: 4vh;
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
    <title>Cannot Buy</title>
    <link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
</head>
<body>
<div class="top">
    <h1 class="main-header">MAXTEK</h1>
    <hr>
</div>
<div>
    <h2>Sorry about that...</h2>
    <h3>Purchase failed. Check inventory, it may be unavailable.</h3>
</div>
<div class = "container">
    <div class="btn-container">
        <a href="/mainscreen" class="btn">Go Back</a>
    </div>
</div>
</body>
</html>
```
<br>

### <strong>File: purchaseSuccess.html<strong> 
Lines 1 - 68 &rarr; added new page that displays purchase success if the item was in inventory
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
        h2, h3{
            text-align: center;
            color: white;
            margin-top: 4vh;
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
    <title>Success!</title>
    <link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
</head>
<body>
<div class="top">
    <h1 class="main-header">MAXTEK</h1>
    <hr>
</div>
<div>
    <h2>Hooray!</h2>
    <h3>Your purchase went through.</h3>

</div>
<div class = "container">
    <div class="btn-container">
        <a href="/mainscreen" class="btn">Go Back</a>
    </div>
</div>
</body>
</html>
```
---
### <em>G) Modify the parts to track maximum and minimum inventory </em> 
### <strong>File: mainscreen.html</strong>
Lines 102 - 103 &rarr; added min/max inventory header cells in hardware/component table
```html
<th>Min Inventory</th>
<th>Max Inventory</th>
```
Lines 112 - 113 &rarr; added min/max inventory to hardware/component table data
```html
<td th:text="${tempPart.minInv}">1</td>
<td th:text="${tempPart.maxInv}">1</td>
```
<br>

### <strong>File: InhousePartForm.html</strong>
Lines 4 - 62 &rarr; changed html head to include styling, title, and favicon for consistency
```html
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
            color: white;
        }
        h2, h3, .form-header{
            text-align: center;
            color: white;
            margin-top: 2vh;
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
        .container {
            display: flex;
            flex-direction: column;
            height: 15vh;
        }
        input[type=text]{
            color: #1e1e76;
            font-weight: bold;
        }
        .form-control {

            background: #a5c9d5;

        }
    </style>
    <title>MAXTEK Hardware</title>
    <link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
</head>
```
Lines 65 - 68 &rarr; added top page header 
```html
<div class="top">
    <h1 class="main-header">MAXTEK</h1>
    <hr>
</div>
```

Line 69 &rarr; changes "inhouse part detail" header to "MAXTEK Hardware Detail"<br>
```html
<h1 class = "form-header">MAXTEK Hardware Detail</h1>
```
Lines 77 - 84 &rarr; added text that corresponds with each text input<br>
```html
    <p><strong class>Name</strong><input type="text" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4"/></p>

    <p><strong class>Price</strong><input type="text" path="price" th:field="*{price}" placeholder= "Price" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('price')}" th:errors="*{price}">Price Error</p>

    <p><strong class>Inventory</strong><input type="text" path="inv" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
        <p th:if="${#fields.hasErrors('inv')}" th:errors="*{inv}">Inventory Error</p>

        <p><strong class>ID</strong><input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/></p>
```
Lines 86 - 89 &rarr; added min/max inventory text fields<br>
```html
        <p><strong class>Min Inventory</strong><input type="text" path="minInv" th:field="*{minInv}" placeholder="Min Inventory" class="form-control mb-4 col-4"/></p>
        <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Min Inventory Error</p>
        <p><strong class>Max Inventory</strong><input type="text" path="maxInv" th:field="*{maxInv}" placeholder="Max Inventory" class="form-control mb-4 col-4"/></p>
        <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Max Inventory Error</p>
```
Lines 90 - 96 &rarr; added a check to see if inventory field has errors and displays them <br>
```html
        <div th:if="${#fields.hasAnyErrors()}">
            <ul>
                <li th:each="err: ${#fields.allErrors()}" th:text="${err}">

                </li>
            </ul>
        </div>
```
Line 100 &rarr; changed return button text to "Go back"

```html
    <a href="http://localhost:8080/" class="btn">Go Back</a>
```
<br>

### <strong>File: OutsourcePartForm.html</strong>
Lines 4 - 62 &rarr; changed html head to include styling, title, and favicon for consistency
```html
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
            color: white;
        }
        h2, h3, .form-header{
            text-align: center;
            color: white;
            margin-top: 2vh;
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
        .container {
            display: flex;
            flex-direction: column;
            height: 15vh;
        }
        input[type=text]{
            color: #1e1e76;
            font-weight: bold;
        }
        .form-control {

            background: #a5c9d5;

        }
    </style>
    <title>3rd Party Hardware</title>
    <link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
</head>
```
Lines 64 - 67 &rarr; added top page header 
```html
<div class="top">
    <h1 class="main-header">MAXTEK</h1>
    <hr>
</div>
```
Line 69 &rarr; changes "outsource part detail" header to "3rd Party Hardware Detail"
```html
<h1 class = "form-header">MAXTEK Hardware Detail</h1>
```
Lines 76 - 84 &rarr; added text that corresponds with each text input
```html
    <p><strong class>Name</strong><input type="text" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4"/></p>

    <p><strong class>Price</strong><input type="text" path="price" th:field="*{price}" placeholder= "Price" class="form-control mb-4 col-4"/></p>
    <p th:if="${#fields.hasErrors('price')}" th:errors="*{price}">Price Error</p>

    <p><strong class>Inventory</strong><input type="text" path="inv" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>
        <p th:if="${#fields.hasErrors('inv')}" th:errors="*{inv}">Inventory Error</p>

        <p><strong class>ID</strong><input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/></p>
```
Lines 86 - 89 &rarr; added min/max inventory text fields
```html
        <p><strong class>Min Inventory</strong><input type="text" path="minInv" th:field="*{minInv}" placeholder="Min Inventory" class="form-control mb-4 col-4"/></p>
        <p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Min Inventory Error</p>
        <p><strong class>Max Inventory</strong><input type="text" path="maxInv" th:field="*{maxInv}" placeholder="Max Inventory" class="form-control mb-4 col-4"/></p>
        <p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Max Inventory Error</p>
```
Lines 91 - 97 &rarr; added a check to see if inventory field has errors and displays them
```html
 <div th:if="${#fields.hasAnyErrors()}">
            <ul>
                <li th:each="err: ${#fields.allErrors()}" th:text="${err}">

                </li>
            </ul>
        </div>
```
Line 100 &rarr; changed return button text to "Go back"

```html
    <a href="http://localhost:8080/" class="btn">Go Back</a>
```
<br>

### <strong>File: InventoryValidator.java</strong>
Lines 1 - 42 &rarr; created a new validator file that checks if the max inventory is exceeded or min inventory is less than what is allowed
```java
package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(part.getInv() > part.getMaxInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory maxed out").addConstraintViolation();
            return false;
        }
        if(part.getInv() < part.getMinInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory below minimum allowed").addConstraintViolation();
            return false;
        }

        return true;
    }
}

```

<br>

### <strong>File: ValidInventory.java</strong>
Lines 1 - 24 &rarr; created a new file that validates the status of inventory when parts are updated
```java
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {InventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInventory {
    String message() default "Inventory Error";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}

```

<br>

### <strong>File: Part.java</strong>

Line 23 &rarr; added annotation in reference to ValidInventory interface

```java
@ValidInventory
```

Lines 34 - 38 &rarr; created max/min inventory values
```java
    @Min(value = 0, message = "Min inventory value must be positive")
    int minInv;
    
    @Min(value = 0, message = "Max inventory value must be positive")
    int maxInv;
```
Lines 91 - 97 &rarr; added getters and setters for max/min inventory values
```java
    public int getMaxInv() {return maxInv;}

    public void setMaxInv(int maxInv) {this.maxInv = maxInv;}

    public int getMinInv() {return minInv;}

    public void setMinInv(int minInv) {this.minInv = minInv;}
```
<br>

### <strong>File: BootStrapData.java</strong>

Lines 83 - 101 &rarr; updated inhouse parts data to include min/max inventory values
```java
        if(inhousePartRepository.count() == 0) {
            InhousePart tower = new InhousePart();
            tower.setName("MAXTEK Stealth ATX/Micro ATX ARGB");
            tower.setInv(100);
            tower.setMinInv(1);
            tower.setMaxInv(1200);
            tower.setId(255);
            tower.setPrice(97.59);
            inhousePartRepository.save(tower);

            InhousePart cooler = new InhousePart();
            cooler.setName("MAKTEK FLEX AIO Water Cooler (360mm)");
            cooler.setInv(67);
            cooler.setMinInv(1);
            cooler.setMaxInv(300);
            cooler.setId(1243);
            cooler.setPrice(114.47);
            inhousePartRepository.save(cooler);
        }
```

Lines 102 - 132 &rarr; updated outsource parts data to include min/max inventory values as well as initialized company names
```java
        if(outsourcedPartRepository.count() == 0){
            OutsourcedPart gpu =  new OutsourcedPart();
            gpu.setName("Avid-N STX 7300-S");
            gpu.setInv(200);
            gpu.setMinInv(1);
            gpu.setMaxInv(500);
            gpu.setCompanyName("Avid-N");
            gpu.setId(50);
            gpu.setPrice(1859.79);
            outsourcedPartRepository.save(gpu);

            OutsourcedPart cpu =  new OutsourcedPart();
            cpu.setName("notel core j56S");
            cpu.setInv(137);
            cpu.setMinInv(1);
            cpu.setMaxInv(250);
            cpu.setCompanyName("notel");
            cpu.setId(890);
            cpu.setPrice(323.49);
            outsourcedPartRepository.save(cpu);

            OutsourcedPart mobo =  new OutsourcedPart();
            mobo.setName("misi motherboard MEG X4390-C");
            mobo.setInv(790);
            mobo.setMinInv(1);
            mobo.setMaxInv(2000);
            mobo.setCompanyName("misi");
            mobo.setId(577);
            mobo.setPrice(129.99);
            outsourcedPartRepository.save(mobo);
        }
```
<br>

### <strong>File: application.properties</strong>
Line 6 &rarr; renamed end of spring.datasource.url to /SzalaiDB-4
```properties
spring.datasource.url=jdbc:h2:file:~/SzalaiDB-4
```

## Additional Changes
### <strong>File: productForm.html</strong>
Lines 4 - 69 &rarr; changed html head to include styling, title, and favicon for consistency
```html
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
            color: white;
        }
        h2, h3, .form-header{
            text-align: center;
            color: white;
            margin-top: 2vh;
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
            margin-bottom: 2vh;
        }
        .container {
            display: flex;
            flex-direction: column;
            height: 15vh;
        }
        input[type=text]{
            color: #1e1e76;
            font-weight: bold;
        }
        .form-control {

            background: #a5c9d5;

        }
        table{
            background-color: #698d9b;
            border-radius: 2px;
            box-shadow: 0px 0px 0px 5px #a5c9d5;
        }
        tbody{
            font-weight: bold;
        }
    </style>
    <title>Prebuilts</title>
    <link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
</head>
```
Lines 71 - 74 &rarr; added top page header
```html
<div class="top">
    <h1 class="main-header">MAXTEK</h1>
    <hr>
</div>
```
Line 76 &rarr; changed form header text to "Prebuilt Detail"
```html
<h1 class="form-header">Prebuilt Detail</h1>
```
Lines 81 - 86 &rarr; added text to correspond with text input
```html
    <p><input type="hidden" th:field="*{id}"/></p>

    <p><strong>Name</strong><input type="text" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4"/></p>

    <p><strong>Price</strong><input type="text" th:field="*{price}" placeholder= "Price" class="form-control mb-4 col-4"/></p>


    <p><strong>Inventory</strong><input type="text" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4"/></p>

```
Line 99 &rarr; changed first table header to "Available Hardware"
```html
<h2>Available Hardware</h2>
```
Line 99 &rarr; changed second table header to "Associated Hardware"
```html
<h2>Associated Hardware</h2>
```
Line 138 &rarr; uncommented and changed a footer with link back to mainscreen labelled "Go Back"
```html
<footer><a href="http://localhost:8080/" class = "btn">Go Back</a></footer>
```
---

### <em>H) Add validation for between or at the maximum and minimum fields.</em>
### <strong>File: MinValidator.java</strong>
Lines 1 - 32 &rarr; added new validator file for minimum inventory
```java
package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MinValidator implements ConstraintValidator<ValidMin, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidMin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() >= part.getMinInv()){
            return true;
        }
        return false;
    }
}

```
<br>

### <strong>File: ValidMin.java</strong>
Lines 1 - 24 &rarr; added new file with interface to work with MinValidator.java and send error custom message
```java
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {MinValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMin {
    String message() default "Below minimum allowed inventory";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}

```
<br>

### <strong>File: MaxValidator.java</strong>
Lines 1 - 29 &rarr; added new validator file for minimum inventory
```java
package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MaxValidator implements ConstraintValidator<ValidMax, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        return part.getMaxInv() >= part.getInv();
    }
}

```

### <strong>File: ValidMax.java</strong>
Lines 1 - 24 &rarr; added new file with interface to work with MaxValidator.java and send error custom message
```java
package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {MaxValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMax {
    String message() default "Exceeds allowed inventory";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}


```
<br>

### <strong>File: EnufPartsValidator.java</strong>
Lines 28 - 59 &rarr; modified isValid method to check if parts used for a product go below the minimum and sends custom message per part
```java
    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        if (product.getId() != 0) {
            Product myProduct = repo.findById((int) product.getId());
            int notEnufCount = 0;
            for (Part p : myProduct.getParts()) {
                if (p.getInv()<=(product.getInv()-myProduct.getInv()-1)) {
                    ++notEnufCount;
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Associated hardware '" + p.getName() + "' too low in inventory").addConstraintViolation();
                }
            }
            if (notEnufCount > 0){
                return false;
            }
            return true;
        }
        else{
                return true;
            }
    }
```
<br>

### <strong>File: Part.java</strong>
Lines 26 - 27 &rarr; added ValidMin/ValidMax annotations to utilize validators
```java
@ValidMax
@ValidMin
```
<br>

### <strong>File: application.properties</strong>
Line 6 &rarr; changed datasource url end to ".../SzalaiDB-5"
```properties
spring.datasource.url=jdbc:h2:file:~/SzalaiDB-5
```

---

### <em>I) Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.</em>
### <strong>File: PartTest.java<strong>
Lines 160 - 176 &rarr; added two unit tests for setters of Max/Min inventory within part class
```java
    @Test
    void setMinInv(){
        int min = 3;
        partIn.setMinInv(min);
        assertEquals(min, partIn.getMinInv());
        partOut.setMinInv(min);
        assertEquals(min, partOut.getMinInv());
    }

    @Test
    void setMaxInv(){
        int max = 3000;
        partIn.setMaxInv(max);
        assertEquals(max, partIn.getMaxInv());
        partOut.setMaxInv(max);
        assertEquals(max, partOut.getMaxInv());
    }
```
---

### <em>J) Remove the class files for any unused validators in order to clean your code.</em>
### <strong><ins>Files Deleted</ins></strong>

* ### <strong>DeletePartValidator.java</strong>
* ### <strong>ValidDeletePart.java</strong>
