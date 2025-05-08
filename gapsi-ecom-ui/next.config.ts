import type { NextConfig } from "next";
import { version } from "os";

const nextConfig: NextConfig = {
  /* config options here */
  publicRuntimeConfig:{
    version,
  }
};

export default nextConfig;
