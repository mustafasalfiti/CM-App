<html>
  <style>
    @import url("https://rsms.me/inter/inter-ui.css");
    ::selection {
      background: #2d2f36;
    }
    ::-webkit-selection {
      background: #2d2f36;
    }
    ::-moz-selection {
      background: #2d2f36;
    }
    body {
      background: white;
      font-family: "Inter UI", sans-serif;
      margin: 0;
      padding: 20px;
    }
    .page {
      background: #e2e2e5;
      display: flex;
      flex-direction: column;
      height: calc(100% - 40px);
      position: absolute;
      place-content: center;
      width: calc(100% - 40px);
    }
    @media (max-width: 767px) {
      .page {
        height: auto;
        margin-bottom: 20px;
        padding-bottom: 20px;
      }
    }
    .container {
      display: flex;
      height: 360px;
      margin: 0 auto;
      width: 640px;
    }
    @media (max-width: 767px) {
      .container {
        flex-direction: column;
        height: 630px;
        width: 320px;
      }
    }
    .left {
      background: white;
      height: calc(100% - 40px);
      top: 20px;
      position: relative;
      width: 50%;
    }
    @media (max-width: 767px) {
      .left {
        height: 100%;
        left: 20px;
        width: calc(100% - 40px);
        max-height: 270px;
      }
    }
    .login {
      font-size: 50px;
      font-weight: 900;
      margin: 50px 40px 40px;
    }
    .eula {
      color: #999;
      font-size: 14px;
      line-height: 1.5;
      margin: 40px;
    }
    .right {
      background: #474a59;
      box-shadow: 0px 0px 40px 16px rgba(0, 0, 0, 0.22);
      color: #f1f1f2;
      position: relative;
      width: 50%;
    }
    @media (max-width: 767px) {
      .right {
        flex-shrink: 0;
        height: 100%;
        width: 100%;
        max-height: 350px;
      }
    }
    svg {
      position: absolute;
      width: 320px;
    }
    path {
      fill: none;
      stroke: url(#linearGradient);
      stroke-width: 4;
      stroke-dasharray: 240 1386;
    }
    .form {
      margin: 40px;
      position: absolute;
    }
    label {
      color: #c2c2c5;
      display: block;
      font-size: 14px;
      height: 16px;
      margin-top: 20px;
      margin-bottom: 5px;
    }
    input {
      background: transparent;
      border: 0;
      color: #f2f2f2;
      font-size: 15px;
      height: 30px;
      line-height: 30px;
      outline: none !important;
      width: 100%;
      border: 1px solid #ff6708;
      padding-left: 10px;
    }

    input::-moz-focus-inner {
      border: 0;
    }
    #submit {
      color: #f2f2f2;
      margin-top: 40px;
      padding-left: 0px;
    }
    #submit:focus {
      color: #fff;
    }
    #submit:active {
      color: #d0d0d2;
    }
  </style>
  <body>
    <div class="page">
      <div class="container">
        <div class="left">
          <div class="login">Register</div>
          <div class="eula">
            When you register you will be able to book tickets for your best
            show!
          </div>
        </div>
        <div class="right">
          <form class="form" method="POST">
            <label for="email">Name</label>
            <input name="name" type="text" id="name" required />
            <label for="email">Email</label>
            <input name="email" type="email" id="email" required />
            <label for="password">Password</label>
            <input name="password" type="password" id="password" required />
            <input type="submit" id="submit" value="Submit" />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
