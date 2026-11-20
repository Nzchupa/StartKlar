/*
 * api.js – alle Anfragen an das Backend
 *
 * Nur in dieser Datei wird fetch() aufgerufen. Andere Skripte benutzen die Funktionen
 * aus dem Objekt "Api", z. B.:
 *     const status = await Api.getStatus();
 * Ändert sich eine Adresse im Backend, muss nur diese Datei angepasst werden.
 *
 * Neue Funktion hinzufügen: nach dem Muster von getStatus() unten,
 * und den Endpunkt in backend/README.md nachschlagen.
 */

const Api = {

    /** Alle Backend-Adressen beginnen mit /api */
    baseUrl: "/api",

    /**
     * Fragt den Status des Backends ab.
     * @returns {Promise<{status: string, application: string}>}
     */
    async getStatus() {
        return this.request("/status");
    },

    /**
     * Hilfsfunktion: schickt eine Anfrage und gibt die Antwort als Objekt zurück.
     * Wirft einen Fehler, wenn das Backend nicht antwortet oder einen Fehler meldet.
     *
     * @param {string} path     Pfad ohne /api, z. B. "/status"
     * @param {object} options  optionale fetch-Optionen (method, body, ...)
     */
    async request(path, options = {}) {
        const response = await fetch(this.baseUrl + path, {
            headers: { "Content-Type": "application/json" },
            ...options
        });

        if (!response.ok) {
            throw new Error("Anfrage fehlgeschlagen: " + response.status);
        }
        return response.json();
    }
};
