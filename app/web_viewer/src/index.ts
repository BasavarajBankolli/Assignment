import { updateStats } from "./ui";

const img = document.getElementById("frame") as HTMLImageElement;

img.onload = () => {
const width = img.naturalWidth;
const height = img.naturalHeight;

let last = performance.now();
let fps = 0;

function animate(now: number) {
fps = 10 / (now - last);
last = now;

updateStats(fps, width, height);
requestAnimationFrame(animate);
}

requestAnimationFrame(animate);
};
