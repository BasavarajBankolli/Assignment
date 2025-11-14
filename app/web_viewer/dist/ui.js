export function updateStats(fps, width, height) {
    const statEl = document.getElementById("stats");
    if (statEl) {
        statEl.textContent = `FPS: ${fps.toFixed(1)} | Resolution: ${width} × ${height}`;
    }
}
