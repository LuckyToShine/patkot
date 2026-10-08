# 👋🧩 Lucky Patches

Template repository for Morphe Patches.

## ❓ About

Patches for apps I like.

<!-- TODO: Update this about section with a brief introduction/summary about this repo and what it offers. -->

### How to use these patches

Click here to add these patches to Morphe: https://morphe.software/add-source?github=LuckyToShine/patkot

## 🩹 Patches list

<!-- PATCHES_START EXPANDED -->
> **[v1.4.0](https://github.com/LuckyToShine/patkot/releases/tag/v1.4.0)**&nbsp;&nbsp;•&nbsp;&nbsp;`main`&nbsp;&nbsp;•&nbsp;&nbsp;4 patches total
<details open>
<summary>📦 Sticker.ly&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.37.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [AMOLED theme](#amoled-theme) | Replaces the light theme with a dark AMOLED theme. Backgrounds become black and dark text becomes light. Pictures (PNG, WebP) and colors set in code are not changed. | • Background color |

</details>

<details open>
<summary>📦 Cinevi&nbsp;&nbsp;•&nbsp;&nbsp;2 patches</summary>
<br>

**🎯 Supported versions:**

| 4.0.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Custom loading video](#custom-loading-video) | Replaces the loading screen shown when a video starts with your own video. WebM (VP9 or AV1) or MP4 (H.265/HEVC). | • Video file<br>• Scaling<br>• Loop<br>• Mute<br>• Hide the original loading screen<br>• Background color<br>• Only accept WebM (VP9/AV1) and MP4 (H.265) |
| [Disable ads](#disable-ads) | Removes ads (splash, banners, popups, interstitials and native ads). |  |

</details>

<details open>
<summary>📦 Iris Gallery&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 0.8.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Move to Secure Folder](#move-to-secure-folder) | Adds Samsung Secure Folder as a destination when moving items to Locked. Only active on devices where Secure Folder is available. |  |

</details>

<!-- PATCHES_END -->

### 🛠️ Building locally

- Run `./gradlew buildAndroid`
- The built patches .mpp file is found in `patches/build/libs/patches-*.mpp`
- Patch the mpp file using [Morphe-Desktop](https://github.com/MorpheApp/morphe-desktop)
  like any other patch bundle.

See the [Morphe documentation](https://github.com/MorpheApp/morphe-documentation) for more information.

## 📜 License

UserXYZ Patches are licensed under the [GNU General Public License v3.0](LICENSE)
