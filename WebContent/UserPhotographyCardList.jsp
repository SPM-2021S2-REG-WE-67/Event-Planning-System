<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>


@import url('https://fonts.googleapis.com/css?family=Lato');

/* default */
*,
*::after,
*::before {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* body */
body {
  min-height: 100vh;
 
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;

  background: hsl(220, 10%, 12%);
  font-family: "Lato", "Segoe Ui", -apple-system, BlinkMacSystemFont, sans-serif;
}

/* .flip-card-container */
.flip-card-container {
  --hue: 150;
  --primary: hsl(var(--hue), 50%, 50%);
  --black: hsl(0, 0%, 0%);
  --black: hsl(0, 0%, 0%);
  --dark: hsl(var(--hue), 25%, 10%);
  --grey: hsl(0, 0%, 50%);

  width: 310px;
  height: 400px;
  margin: 40px;

  perspective: 1000px;
}

/* .flip-card */
.flip-card {
  width: inherit;
  height: inherit;

  position: relative;
  transform-style: preserve-3d;
  transition: .6s .1s;
}

/* hover and focus-within states */
.flip-card-container:hover .flip-card,
.flip-card-container:focus-within .flip-card {
  transform: rotateY(180deg);
}

/* .card-... */
.card-front,
.card-back {
  width: 100%;
  height: 100%;
  border-radius: 24px;

  background: var(--dark);
  position: absolute;
  top: 0;
  left: 0;
  overflow: hidden;

  backface-visibility: hidden;

  display: flex;
  justify-content: center;
  align-items: center;
}

/* .card-front */
.card-front {
  transform: rotateY(0deg);
  z-index: 2;
}

/* .card-back */
.card-back {
  transform: rotateY(180deg);
  z-index: 1;
}

/* figure */
figure {
  z-index: -1;
}

/* figure, .img-bg */
figure,
.img-bg {
  position: absolute;
  top: 0;
  left: 0;

  width: 100%;
  height: 100%;
}

/* img */
img {
width:100%;
  height: 100%;
  border-radius: 24px;
}

/* figcaption */
figcaption {
  display: block;

  width: auto;
  margin-top: 12%;
  padding: 8px 22px;

  font-weight: bold;
  line-height: 1.6;
  letter-spacing: 2px;
  word-spacing: 6px;
  text-align: right;

  position: absolute;
  top: 0;
  right: 12px;

  color: var(--white-1);
  background: hsla(var(--hue), 25%, 10%, .5);
}

/* .img-bg */
.img-bg {
  background: hsla(var(--hue), 25%, 10%, .5);
}

.card-front .img-bg {
  clip-path: polygon(0 20%, 100% 40%, 100% 100%, 0 100%);
}

.card-front .img-bg::before {
  content: "";

  position: absolute;
  top: 34%;
  left: 50%;
  transform: translate(-50%, -50%) rotate(18deg);

  width: 100%;
  height: 6px;
  border: 1px solid var(--primary);
  border-left-color: transparent;
  border-right-color: transparent;

  transition: .1s;
}

.card-back .img-bg {
  clip-path: polygon(0 0, 100% 0, 100% 80%, 0 60%);
}

/* hover state */
.flip-card-container:hover .card-front .img-bg::before {
  width: 6px;
  border-left-color: var(--primary);
  border-right-color: var(--primary);
}

/* ul */
ul {
  padding-top: 50%;
  margin: 0 auto;
  width: 70%;
  height: 100%;

  list-style: none;
  color: var(--white-1);

  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

/* li */
li {
  width: 100%;
  margin-top: 12px;
  padding-bottom: 12px;

  font-size: 14px;
  text-align: center;

  position: relative;
}

li:nth-child(2n) {
  color: var(--white-2);
}

li:not(:last-child)::after {
  content: "";

  position: absolute;
  bottom: 0;
  left: 0;

  width: 100%;
  height: 1px;

  background: currentColor;
  opacity: .2;
}

/* button */
button {
  font-family: inherit;
  font-weight: bold;
  color: var(--black);

  letter-spacing: 2px;

  padding: 9px 20px;
  border: 1px solid var(--black);
  border-radius: 1000px;
  background: transparent;
  transition: .3s;

  cursor: pointer;
}

button:hover,
button:focus {
  color: var(--black);
  background: hsla(var(--hue), 25%, 10%, .2);
  border-color: currentColor;
}

button:active {
  transform: translate(2px);
}

/* .design-container */
.design-container {
  --tr: 90;
  --op: .5;

  width: 100%;
  height: 100%;

  background: transparent;
  position: absolute;
  top: 0;
  left: 0;

  pointer-events: none;
}

/* .design */
.design {
  display: block;

  background: var(--grey);
  position: absolute;

  opacity: var(--op);
  transition: .3s;
}

.design--1,
.design--2,
.design--3,
.design--4 {
  width: 1px;
  height: 100%;
}

.design--1,
.design--2 {
  top: 0;
  transform: translateY(calc((var(--tr) - (var(--tr) * 2)) * 1%))
}

.design--1 {
  left: 20%;
}

.design--2 {
  left: 80%;
}

.design--3,
.design--4 {
  bottom: 0;
  transform: translateY(calc((var(--tr) + (var(--tr) - var(--tr))) * 1%))
}

.design--3 {
  left: 24%;
}

.design--4 {
  left: 76%;
}

.design--5,
.design--6,
.design--7,
.design--8 {
  width: 100%;
  height: 1px;
}

.design--5,
.design--6 {
  left: 0;
  transform: translateX(calc((var(--tr) - (var(--tr) * 2)) * 1%));
}

.design--5 {
  top: 41%;
}

.design--6 {
  top: 59%;
}

.design--7,
.design--8 {
  right: 0;
  transform: translateX(calc((var(--tr) + (var(--tr) - var(--tr))) * 1%))
}

.design--7 {
  top: 44%;
}

.design--8 {
  top: 56%;
}

/* states */
button:hover+.design-container,
button:active+.design-container,
button:focus+.design-container {
  --tr: 20;
  --op: .7;
}

.abs-site-link {
  position: fixed;
  bottom: 20px;
  left: 20px;
  color: hsla(0, 0%, 100%, .6);
  font-size: 16px;
  font-family: 'Segoe UI', -apple-system, BlinkMacSystemFont, sans-serif;
}

</style>
<div style="width: 100%;
    float: right;background-color: white;
    padding: 8px;
        text-align: right;
    ">
<button onclick="window.location.href='MemberView.jsp'" style="background-color:blue;color:white;padding:10px 20px;" class="btn-primary">Go to Home
</button>

</div>
<body>

	<c:forEach var="user" items="${listPhotographys}">

<!-- flip-card-container -->
<div class="flip-card-container" style="--hue: 350">
  <div class="flip-card">

    <div class="card-front">
      <figure>
        <div class="img-bg"></div>
        <img src=<c:out value="${user.path}" /> >
       
      </figure>

      <ul>
        <li>Studio Name :<c:out value="${user.studioname}" /></li>
        <li>Available Services: <c:out value="${user.availableservices}" /> </li>
        <li> Working Days : <c:out value="${user.workingdays}" /></li>
      <li> Location : <c:out value="${user.location}" /></li>
      </ul>
    </div>

    <div class="card-back">
      <!-- only if the image is necessary -->
      <figure>
        <div class="img-bg"></div>
        <img src="<c:out value="${user.path}" />" >
      </figure>

      <button onclick="window.location.href='<%=request.getContextPath()%>/newUserPhotographyBook'" >Book</button>

      <!-- can add svg here and remove these eight spans -->
      <div class="design-container">
        <span class="design design--1"></span>
        <span class="design design--2"></span>
        <span class="design design--3"></span>
        <span class="design design--4"></span>
        <span class="design design--5"></span>
        <span class="design design--6"></span>
        <span class="design design--7"></span>
        <span class="design design--8"></span>
      </div>
    </div>

  </div>
</div>
<!-- /flip-card-container -->

</c:forEach>
</body>