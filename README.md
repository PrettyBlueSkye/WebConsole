### UPDATED TO 1.20.x MINECRAFT
updated the fabric port of the plugin, to 1.20 so it works past 1.18!

# WebConsole

[![CurseForge](http://cf.way2muchnoise.eu/564872.svg)](https://www.curseforge.com/minecraft/mc-mods/webconsole)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/t2pellet/WebConsole)](https://github.com/t2pellet/WebConsole/releases/latest)

WebConsole is a Fabric mod for Minecraft 1.20+ that allows you to view your server console and manage your server from anywhere. It creates a WebSocket server in the background used by the web interface to send commands, receive your console log and manage your server.

Don't worry about privacy or security: all data is stored in your browser locally and your PC will connect directly to your minecraft server. No intermediary web servers, just you and your MC server.

#### Additional features:
* Multiuser system and View-only user mode: You can create multiple users and set their role to "Admin" or "Viewer". Users with the role "Viewer" can only read console, CPU and RAM usage. Users with role "Admin" can also run commands on the server. Useful if you want your friends to watch the server console but deny them from typing commands and ruining your server. Also, you can whitelist or blacklist some commands.
* Command history: Use up/down arrow keys to browse the command history, like in the real console.
* Colors supported, for both Windows and Linux hosts. (Colors are represented different in each platform).
* Real-time connected players, machine CPU and server RAM usage information.
* Capable of keeping active connections to more than one server to keep retrieving console log in the background for them all.
* English, Spanish, Chinese (thanks to Neubulae and OPhantomO), Czech (thanks to Tada), Deutsch (thanks to NoNamePro0), Dutch (thanks to Twockx), French (thanks to pickatchou999), Italian (thanks to AlexZap), Japanese (thanks to kuroneko6423), Korean (thanks to XxPKBxX), Portuguese (thanks to AlexandreMuassab and Connect500BR), Russian (thanks to Stashenko) and Turkish (thanks to acarnd03) supported.
* Free!

![Screenshot](https://i.imgur.com/sN1sYju.png)


## Mod installation

1. Download mod from [Releases](https://www.curseforge.com/minecraft/mc-mods/webconsole/files).
2. Start your server to see the webconsole.json5 config file. Should appear like this:
![image](https://i.imgur.com/G4WoOlu.png)
3. Ensure both the client and socket port are port-forwarded.

A explanation of the `host`, `port`, `language` and `passwords` fields follows:
- `host`: Leaving it as 0.0.0.0 will do the trick. If you experience issues , you can change this value to your device IP. If you are in a VPS or dedicated server (or you have a full public IP allocated for your device) type your public IP. If you are at your home (and you don't have a public IP assigned to your device) type your private IP, it is probably something like 192.168.xx.xx.
- `useIntegratedWebServer`: Determines whether to enable the integrated web client server or not
- `clientPort`: The port for the integrated web server, if enabled. Must be port forwarded if `useIntegratedWebServer==true`
- `socketPort`: The port for the WebSocket server. Must be port forwarded
- You can modify `language` to view console and command messages in your preferred language. Valid languages are English (`en`), Spanish (`es`), Chinese (`zh`), Czech (`cs`), Deutsch (`de`), Dutch (`nl`), French (`fr`), Italian (`it`), Japanese (`ja`) Korean (`ko`), Portuguese (`pt`), Russian (`ru`) and Turkish (`tr`). **IMPORTANT: There is a known issue with Microsoft Windows cmd that shows weird characters when using a language different than English. If you are using Windows to host your server, check [this wiki page](https://github.com/mesacarlos/WebConsole/wiki/Show-local-characters-in-Windows-Console) to solve the problem**.
- You can modify the `users` array to add/remove/edit different users with varying permissions for accessing the web console. By default, an "admin" user is created as an example for the syntax.

The rest of the fields are used for SSL configuration. You can learn how to activate SSL [here](https://github.com/mesacarlos/WebConsole/wiki/SSL-Configuration). SSL **is not** required for WebConsole to work, you can still use it without encription, unless you are hosting your client in a HTTPS server, in this case is mandatory to enable SSL in all your servers due to web browsers restrictions.


## Using web interface

By default, the mod will run an integrated web client server as well as the web socket server.
- The WebSocket server will be at `host : socketPort` specified in config
- The WebServer will use `clientPort` specified in config
- You can disable the integrated web server via `useIntegratedWebServer` in the config

You can download the client web interface from [Releases](https://github.com/t2pellet/WebConsole/releases) or from [MesaCarlos' releases](https://github.com/mesacarlos/WebConsole/releases) if you want an interface supporting multiple different servers.

## Check connected WebConsole clients
Since v1.3, you can use /WebConsole command to view how many clients are connected and their IP address. This is the only Minecraft command provided by this plugin. This command requires you to have `webconsole.webconsole` permission to execute it.


## Technical information

You can find how client and server communicate [here](https://github.com/mesacarlos/WebConsole/wiki/WebSocket-commands-and-responses).

## Bugs, suggestions or problems configuring WebConsole?
You can open an issue on [GitHub](https://github.com/t2pellet/WebConsole/issues)
