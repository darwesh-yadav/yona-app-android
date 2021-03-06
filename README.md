# Yona [You Are Not Alone]

## Application definition statement

Main concept of Yona is to know user how much time they are utilizing on mobile device like multimedia, social, etc categories daily.

## References

* [Architecture](Architecture.md)
* [Jira](http://jira.yona.nu/secure/RapidBoard.jspa?projectKey=APPDEV&useStoredSettings=true&rapidView=6)
* [Jenkins-Development](https://jenkins-mobile.eu.mobproto.com/job/Yona/)
* [Jenkins-Acceptance](https://jenkins-mobile.eu.mobproto.com/job/Yona-ACC/)
* [Hockey-Development](https://rink.hockeyapp.net/manage/apps/308021)
* [Hockey-Acceptance](https://rink.hockeyapp.net/manage/apps/366916)
* [Server source code](https://github.com/yonadev/yona-server)

## People

* Project manager: Yvonne Dieks <ydieks@mobiquityinc.com>
* Tech lead: Kinnar Vasa <kvasa@mobiquityinc.com>

## Prerequisites

- Android versions supported `4.4+`
- Build with SDK `23.0.1`
- Works on `Android Device`

## Environment setup

Checkout and run!

## Schemes, targets and build flags

- **zdev**: Development builds. Will work with the development server, this is disable with hockey app crash analytics.
- **zdevlopment**: Development builds. Will work with the development server, this is enable with hockey app crash analytics.
- **zacceptance**: Acceptance/UAT builds. Will work with the acceptance server.

## UAT build

1. Jenkins build
2. Auto clean and build with incremental build version.
3. Upload to HockeyApp
4. Add updates to the HockeyApp release notes
