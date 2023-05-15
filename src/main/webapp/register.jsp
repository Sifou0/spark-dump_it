<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Register</title></head>
<script src="https://cdn.tailwindcss.com"></script>
<body>
<div class="items-center justify-center py-4 h-screen">
    <img src="https://www.spark-archives.com/sites/default/files/images/capital.png" id="logo" class="p-0"  alt="logo spark"/>
    <div class="flex w-screen h-1/3 items-center justify-evenly my-32">
        <form action="register" method="post" class="w-full max-w-md">
            <div class="mb-6 md:flex md:items-center">
                <div class="md:w-1/3">
                    <label class="mb-1 block pr-4 font-bold text-gray-500 md:mb-0 md:text-right" for="username"> Nom d'utilisateur </label>
                </div>
                <div class="md:w-2/3">
                    <input class="w-full appearance-none rounded border-2 border-gray-200 bg-gray-200 px-4 py-2 leading-tight text-gray-700 focus:border-[#357cce] focus:bg-white focus:outline-none" name="username" id="username" type="text" placeholder="test@kleegroup.com" />
                </div>
            </div>
            <div class="mb-6 md:flex md:items-center">
                <div class="md:w-1/3">
                    <label class="mb-1 block pr-4 font-bold text-gray-500 md:mb-0 md:text-right" for="password"> Mot de passe </label>
                </div>
                <div class="md:w-2/3">
                    <input name="password" class="w-full appearance-none rounded border-2 border-gray-200 bg-gray-200 px-4 py-2 leading-tight text-gray-700 focus:border-[#357cce] focus:bg-white focus:outline-none"type="password" id="password" placeholder="******************" />
                </div>
            </div>
            <div class="md:flex md:items-center">
                <div class="md:w-1/3"></div>
                <div class="md:w-2/3">
                    <button class="focus:shadow-outline rounded bg-[#357cce] px-4 py-2 font-bold text-white shadow hover:bg-[#3D8CE6] focus:outline-none" type="submit">S'inscrire</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
