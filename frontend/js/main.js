/*
 * main.js – gemeinsamer Code für alle Seiten
 *
 * Wird auf jeder Seite nach api.js geladen. Code, der nur eine einzelne Seite betrifft,
 * gehört nicht hierher, sondern in js/pages/<seitenname>.js.
 */

/**
 * Zeigt im Footer an, ob das Backend erreichbar ist.
 * Das Element mit der id "backend-status" steht in jeder Seite im Footer.
 */
async function showBackendStatus() {
    const element = document.getElementById("backend-status");
    if (!element) {
        return;
    }

    try {
        await Api.getStatus();
        element.textContent = "Backend verbunden";
        element.classList.add("backend-status--ok");
    } catch (error) {
        element.textContent = "Backend nicht erreichbar";
        element.classList.add("backend-status--error");
    }
}

showBackendStatus();
