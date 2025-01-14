
# WESTERN GOVERNORS UNIVERSITY <br><sup>D287 – JAVA FRAMEWORKS</sup>

## <ins>Changes</ins>
### <em>C) Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.</em>
### <strong>File: mainscreen.html<strong>

---
Line 14 &rarr; renamed shop title to "MAXTEK"
<br>Line 15 &rarr; added mouse image to favicon</br>
```html
<title>MAXTEK</title>
<link rel = "icon" type = "image/x-icon" href="/img/pcmouse.jpg">
```
---
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
---

Line 67 - 70 &rarr; added div container for top section of page
<br>Line 68 &rarr; changed header to MAXTEK and included a class for styling </br>
```html
<div class = "top">
    <h1 class = "main-header">MAXTEK</h1>
    <hr>
</div>
```
---
Line 71 &rarr; changed header from "Parts" to "System Components"
```html
<h2>Hardware</h2>
```
---
Lines 73 &rarr; changed input to include "filter-box" class for styling
```html
Filter: <input type="text" name="partkeyword" id="partkeyword" class = "filter-box" size="50" th:value="${partkeyword}" required />
```
---
Line 103 &rarr; changed header from "Products" to "Prebuilt Systems"
```html
<h2>Prebuilt Systems</h2>
```
---
Line 105 &rarr; changed input to include "filter-box" class for styling
```html
Filter: <input type="text" name="productkeyword" id="productkeyword" class = "filter-box" size="50" th:value="${productkeyword}" required />
```
---
Line 117 &rarr; changed button text to "Add Prebuilt"
```html
<a th:href="@{/showFormAddProduct}" class="btn btn-primary btn-sm mb-3">Add Prebuilt</a>
```
---