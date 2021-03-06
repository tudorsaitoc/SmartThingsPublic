definition(
    name: "Rule Machine",
    singleInstance: true,
    namespace: "bravenel",
    author: "Mike Maxwell",
    description: "Rule Machine",
    category: "My Apps",
  	iconUrl: "https://s3.amazonaws.com/smartapp-icons/ModeMagic/Cat-ModeMagic.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/ModeMagic/Cat-ModeMagic@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/ModeMagic/Cat-ModeMagic@3x.png"
)

preferences {
    page(name: "mainPage", title: "Rules", install: true, uninstall: true,submitOnChange: true) {
            section {
                    app(name: "childRules", appName: "Rule", namespace: "bravenel", title: "Create New Rule...", multiple: true)
            }
    }
}

def installed() {
    initialize()
}

def updated() {
    unsubscribe()
    initialize()
}

def initialize() {
    childApps.each {child ->
            log.info "Installed Rules: ${child.label}"
    }
}