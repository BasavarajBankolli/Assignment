


export function updateStats(fps: number, width: number, height: number) {
    const statEl = document.getElementById("stats");
    if (statEl) {
        statEl.textContent = `FPS: ${fps.toFixed(1)} | Resolution: ${width} × ${height}`;
    }
}
